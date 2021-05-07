<template>
    <v-container   fluid class="mt-12">
        <v-row align="center" justify="center" class="mt-12">

            <v-col cols="12" sm="8" md="5" offset-md="1">
                <v-card class="elevation-12">
                    <v-toolbar  dark flat>
                        <v-toolbar-title>Вход в систему</v-toolbar-title>
                        <v-spacer/>
                    </v-toolbar>
                    <v-card-text>
                        <v-alert :value="error" type="warning">
                            {{error}}
                        </v-alert>
                        <v-form v-model="valid">
                            <v-text-field v-on:keyup.enter="signIn" label="Логин" name="login" prepend-icon="person"
                                          type="text" required v-model="editedItem.username" :rules="loginRules"/>
                            <v-text-field v-on:keyup.enter="signIn" id="password" label="Пароль" name="password"
                                          prepend-icon="lock"
                                          type="password" required v-model='editedItem.password' :rules="passwordRules"/>
                        </v-form>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer/>
                        <v-btn color="blue" @click.prevent="signIn" :disabled="processing || !valid">Вход</v-btn>
                    </v-card-actions>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>

    export default {
        name: "Login",
        data() {
            return {
                data: {
                    header: {
                        service: '',
                        operation: '',
                        hash: ''
                    },

                },
                editedItem:
                    {
                        username:'',
                        password:''
                    },
                login: null,
                password: null,
                valid: false,
                loginRules: [
                    (v) => !!v || 'Пожалуйста введите логин'
                ],
                passwordRules: [
                    (v) => !!v || 'Пожалуйста введите пароль',
                    (v) => (v && v.length > 0) || 'Логин слишком короткий - минимум 6 символов'
                ]
            }
        },
        computed: {
            error() {
                //getters обьявляем ка кпростые переменные
                return this.$store.getters.getError
            },
            processing() {
                return this.$store.getters.getProcessing
            },
            isAuthenticated() {
                return this.$store.getters.isUserAuthenticated
            }
        },
        methods: {
            signIn() {
                console.log(this.editedItem)
                this.$store.dispatch('SIGN_IN', {
                    data:this.editedItem,
                    statusEnter:this.statusSucces,
                    statusErr:this.statusError,
                    url: '/weatheradventure/autorization'
                })
            },
            statusSucces(){
                this.$router.push("/")
            },
            statusError(){

                this.flashMessage.error({
                    title: 'Ошибка',
                    message: 'Данный аккаунт не сущесвтует или заблокирован'
                });

            }
        },

    }
</script>

<style scoped>

</style>