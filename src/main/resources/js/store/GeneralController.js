import Vue from 'vue'
import axios from "axios";
import VueAxios from "vue-axios";

Vue.use(VueAxios, axios)
export default {
    state: {
        data: null,
        error: null,
        processing: false,
        gateUrl:'/weatheradventure'
    },
    mutations: {
        SET_PROCESSING(state, payload) {
            state.processing = payload
        },
        SET_DATA(state, payload) {
            state.data = payload
        },
        SET_ERROR(state, payload) {
            state.error = payload
        },
        CLEAN_ERROR(state) {
            state.error = null
        }

    },
    actions: {
        GET_ABOUT_ME({dispatch, commit}, payload) {
            commit('CLEAN_ERROR')
            dispatch('SEND_REQUEST_GET', payload)
                .then(resolve => {
                        console.log('GET_ABOUT_ME', resolve)
                        payload.showInfoAboutMe(resolve)


                    }
                )
        },
        SEND_REQUEST_GET({commit, getters}, payload) {
            // console.log('main payload',payload)
            var url=getters.getGateUrl+payload.url
            return new Promise((resolve, reject) => {
                Vue.axios.get(url, {
                    headers: {Authorization: getters.getToken}
                })
                    .then(resp => {
                        commit('CLEAN_ERROR')
                        console.log('get Response ', resp.data)
                        // commit('SET_DATA', resp.data)
                        resolve(resp.data)

                    }).catch(err => {
                    commit('SET_ERROR', 'Ошибка подключения')
                    console.log('error connect')
                    reject(err)
                })
            });
        },

        SEND_REQUEST_POST({commit,getters}, payload) {
            console.log("POST", payload)
            // console.log('main payload',payload)
            return new Promise((resolve, reject) => {
                Vue.axios.post(payload.url, payload.data,{
                    headers: {Authorization: getters.getToken}
                })
                    .then(resp => {
                        commit('CLEAN_ERROR')
                        console.log('get Response ', resp)
                        resolve(resp.data)
                    }).catch(err => {
                    reject(err)
                })
            });
        },
        GET_GENERAL_REQUEST({dispatch}, payload) {
            dispatch('SEND_REQUEST_GET', payload)
                .then(resolve => {
                        console.log(resolve)
                        payload.setList(resolve)

                    }
                )
        },
        POST_GENERAL_REQUEST({dispatch}, payload) {
            if (profile == 'test') {
                payload.url = test_server + payload.url
            } else {
                payload.url = deploy_server + payload.url
            }
            dispatch('SEND_REQUEST_POST', {
                url: payload.url,
                data: payload.data
            })
                .then(resolve => {

                        payload.getSucces(resolve)

                    }
                )
        },
        SEND_REQUEST_DELETE({commit}, payload) {
            // console.log('main payload',payload)
            return new Promise((resolve, reject) => {
                Vue.axios.delete(payload.url)
                    .then(resp => {
                        commit('CLEAN_ERROR')
                        console.log('get Response ', resp.data)
                        // commit('SET_DATA', resp.data)
                        resolve(resp.data)

                    }).catch(err => {
                    commit('SET_ERROR', 'Ошибка подключения')
                    console.log('error connect')
                    reject(err)
                })
            });
        },
        AUTH_SEND_REQUEST_POST({commit}, payload) {
            console.log("POST", payload)
            // console.log('main payload',payload)
            return new Promise((resolve, reject) => {
                Vue.axios.post(payload.url, payload.data)
                    .then(resp => {

                        commit('CLEAN_ERROR')
                        if (resp.data.token == null) {
                            commit('SET_ERROR', "Данный пользователь не существует ")
                        }  else {
                            console.log('get Response ', resp)
                            resolve(resp.data)
                        }
                        if (resp.data.textError!=null)
                        {
                            commit('SET_ERROR', resp.data.textError)
                        }
                    }).catch(err => {
                    reject(err)
                })
            });
        },
    },
    getters: {
        getData: (state) => state.data,
        getError: (state) => state.error,
        getGateUrl:(state)=>state.gateUrl
    }
}