export default {
    state:{},
    mutations:{

    },
    actions:{
        ADD_NEW_USER({dispatch, commit}, payload) {
            commit('CLEAN_ERROR')
            dispatch('SEND_REQUEST_POST', {
                url: payload.url,
                data: payload.data
            })
                .then(resolve => {
                        if (resolve.duplicateLogin == true)

                        {
                            commit('SET_ERROR',  'Пользователь с таким логином уже сущесвтует')
                            payload.status_error('Пользователь с таким логином уже сущесвтует')
                        }
                        else
                            payload.status_save()

                    }
                )
        },
    },
    getters:{}
}