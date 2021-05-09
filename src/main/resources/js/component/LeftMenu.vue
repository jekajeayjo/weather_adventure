<template>
    <v-navigation-drawer
            id="layer1"


            :width="350"
            expand-on-hover
            mini-variant
            absolute
            dark
            permanent
            overlay-color="white"
            class="pt-12"
            color="#444"
    >
        <v-list
                dense
                nav
                class="py-0"
                shaped

        >
            <v-list-item-content>
                <v-list-item-title class="title">
                    {{userDetail.fio}}
                </v-list-item-title>
                <!--                <v-list-item-subtitle> Логин: {{userDetail.userName}}</v-list-item-subtitle>-->
                <v-list-item-subtitle> Уровень доступа: {{userDetail.roleName}}</v-list-item-subtitle>
            </v-list-item-content>

            <div class="mt-7">

                <!--            <v-divider class=""></v-divider>-->
                <div v-for="link  in menuList" :key="link.name"

                >
                    <!-- первый уровень-->
                    <v-list-item

                            v-if="link.route!=''"
                            link :to="link.route"


                    >

                        <v-list-item-icon>
                            <v-icon>{{ link.icon }}</v-icon>
                        </v-list-item-icon>

                        <v-list-item-content>
                            <v-list-item-title>{{ link.name }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <!--переходим на второй уровень-->
                    <v-list-group
                            v-else
                            no-action
                            :color="'#b1cd33'"
                    >

                        <template
                                v-slot:activator>
                            <v-list-item-icon>
                                <v-icon>{{ link.icon }}</v-icon>
                            </v-list-item-icon>

                            <v-list-item-content>
                                <v-list-item-title style="font-weight: bold;font-size: 14px">{{ link.name }}
                                </v-list-item-title>
                            </v-list-item-content>
                        </template>
                        <!--отобразить данные второго уровня-->
                        <div v-for="sublink  in link.children" :key="sublink.name">

                            <!--отобразить список элементов второго уровня-->
                            <v-list-item

                                    v-if="sublink.route!=''"
                                    link :to="sublink.route"
                                    :key="sublink.name"
                                    :color="'green'"
                            >
                                <v-list-item-content>
                                    <v-list-item-title>{{ sublink.name }}</v-list-item-title>
                                </v-list-item-content>
                                <v-list-item-icon>
                                    <v-icon>{{ sublink.icon }}</v-icon>
                                </v-list-item-icon>
                            </v-list-item>

                            <!--                        отобразить список групп третьего уровня-->
                            <v-list-group
                                    :sub-group="sublink.children"
                                    v-else
                                    no-action
                                    :color="'red'"
                            >

                                <template
                                        v-slot:activator>
                                    <v-list-item-icon>
                                        <v-icon>{{ sublink.icon }}</v-icon>
                                    </v-list-item-icon>

                                    <v-list-item-content>
                                        <v-list-item-title style="font-weight: bold;font-size: 14px">{{ sublink.name
                                            }}
                                        </v-list-item-title>
                                    </v-list-item-content>
                                </template>
                                <!--отобразить список элементов 3 уровня-->
                                <v-list-item
                                        :color="'yellow'"

                                        v-for="sub3link in sublink.children"
                                        link :to="sub3link.route"
                                        :key="sub3link.name"
                                >

                                    <v-list-item-icon>
                                        <v-icon>{{ sub3link.icon }}</v-icon>
                                    </v-list-item-icon>

                                    <v-list-item-content>
                                        <v-list-item-title>{{ sub3link.name }}</v-list-item-title>
                                    </v-list-item-content>
                                </v-list-item>


                            </v-list-group>
                        </div>

                    </v-list-group>
                </div>
            </div>
        </v-list>
    </v-navigation-drawer>
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
                    url: '/dictionary/get_menu'
                })
            }
        }
    }
</script>

<style scoped>

</style>