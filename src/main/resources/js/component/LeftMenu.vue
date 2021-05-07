<template>
    <div >
        <v-navigation-drawer

                src=""
                expand-on-hover
                mini-variant
                absolute
                dark
                permanent
        >
            <v-list
shaped
                    dense
                    nav
                    class="py-0 mt-6 pt-12"
            >

                <div v-for="item in menuList" :key="item.id">
                    <v-list-item
                            v-if="item.route!=''"
                            :key="item.names"
                            link
                            :to="item.route"
                            avatar
                    >

                        <v-list-item-icon>
                            <v-icon>{{ item.icon }}</v-icon>
                        </v-list-item-icon>

                        <v-list-item-content>
                            <v-list-item-title>{{ item.name }}</v-list-item-title>
                        </v-list-item-content>

                    </v-list-item>
                </div>
            </v-list>
        </v-navigation-drawer>
    </div>
</template>

<script>
    export default {
        name: "LeftMenu",
        data() {
            return {
                ss:''
            }
        },
        computed: {
            userDetail() {
                return this.$store.getters.getUser
            },
            menuList() {
                return this.$store.getters.getMenuList
            }
        },
        created() {
            this.getMenuList()
        },
        methods: {
            getMenuList() {
                this.$store.dispatch('GET_MENU_LIST', {
                    data: '',
                    url: '/menu?id=' + this.userDetail.idUser
                })
            }
        }
    }
</script>

<style scoped>

</style>