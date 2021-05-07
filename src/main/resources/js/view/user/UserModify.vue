<template>
    <v-container>
        <v-card>
            <v-form
                    ref="form"
                    v-model="buttonSave"
                    lazy-validation>
                <v-row dense class="ma-2">
                    <v-col cols="12" sm="6" md="6" offset-md="3">
                        <v-text-field
                                dense
:rules="fieldRule"
                                prepend-icon="store"
                                autofocus
                                label="Фамилия"
                                outlined
                                clearable
                                v-model='editedItem.fam'
                        ></v-text-field>
                    </v-col>




                    <v-col sm="6" md="6" offset-md="3">
                        <v-text-field
                                dense
                                outlined
                                clearable
                                v-model="editedItem.im"
                                prepend-icon="supervisor_account"
                                label="Имя"

                                :rules="fieldRule"
                                item-text="name"
                                item-value="id"

                        ></v-text-field>
                    </v-col>
                    <v-col sm="6" md="6" offset-md="3">
                        <v-text-field
                                dense
                                outlined
                                clearable
                                v-model="editedItem.ot"
                                prepend-icon="supervisor_account"
                                label="Отчество"
                                :rules="fieldRule"

                                item-text="name"
                                item-value="id"

                        ></v-text-field>
                    </v-col>
                    <v-col sm="6" md="6" offset-md="3">
                        <v-text-field
                                dense
                                outlined
                                clearable
                                v-model="editedItem.login"
                                prepend-icon="supervisor_account"
                                label="Логин"
                                :rules="fieldRule"

                                item-text="name"
                                item-value="id"

                        ></v-text-field>
                    </v-col>
                    <v-col sm="6" md="6" offset-md="3">
                        <v-text-field
                                dense
                                outlined
                                clearable
                                v-model="editedItem.password"
                                prepend-icon="supervisor_account"
                                label="Пароль"
                                :rules="fieldRule"
                                item-text="name"
                                item-value="id"

                        ></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="5" offset-md="7">
                        <v-switch
                                v-model="editedItem.active"
                                :label="`Активен`"
                        ></v-switch>
                    </v-col>
                </v-row>
                <v-toolbar dense flat>
                    <v-spacer></v-spacer>
                    <v-btn class="mr-1" bottom color="red" @click="returnTolist()">Отмена</v-btn>
                    <v-btn bottom color="green" :disabled="!buttonSave" @click="save()">Сохранить</v-btn>
                </v-toolbar>

            </v-form>
        </v-card>
    </v-container>
</template>

<script>
    export default {
        name: "UserModify",
        data() {
            return {
                fieldRule:[
                    (v) => !!v || 'Пожалуйста заполните поле'
                ],
                buttonSave:false,
                editedItem:{
                    active:false,
                    fam:'',
                    im:'',
                    ot:'',
                    login:'',
                    password:'',
                    birthDate:''
                }
            }
            },
        methods:{
            returnTolist()
            {

            }   ,
            save() {
                this.$store.dispatch('ADD_NEW_USER', {
                    data: this.editedItem,
                    url: '/weatheradventure/user/save',
                    status_save:this.susccesStatus
                })
            },
            susccesStatus() {
                this.$swal("Запись сохранена!", {
                    icon: "success",
                });
            },
        }
    }
</script>

<style scoped>

</style>