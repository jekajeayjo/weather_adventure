import Store from './store'
import Vue from 'vue'
import VueRouter from 'vue-router'

import MainPage from "./view/main/MainPage.vue";

import UserModify from "./view/user/UserModify.vue";

import Login from "./pages/Login.vue";

Vue.use(VueRouter)
let router = new VueRouter({
    routes: [
        {path:'/',component: MainPage,meta: {authRequired: true}},
        {path:'/user_modify',component: UserModify},
        // {path:'/redactor_groups',component: ModeratorGroupsView,meta: {authRequired: true}},



        {path:'/login',component: Login},

    ]
})

router.beforeEach((to, from, next) => {
    Store.dispatch('INIT_AUTH')
        .then(user => {
            if (to.matched.some(route => route.meta.authRequired)) {
                if(user)
                    next()
                else
                    next('login')
            } else {
                next()
            }
        })

})

// // первый способ проерки guard
// function AuthGuard(from,to,next) {
// if (Store.getters.isUserAuthenticated)
//     next()
//     else
//         next('login')
// }
export default router