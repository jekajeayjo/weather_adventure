<template>
    <v-card class="ml-5 mr-2">

        <!--        КНОПКА ДЛЯ ПОИСКА-->
        <v-card-title>
            <v-text-field
                    dense
                    v-model="search"
                    append-icon="search"
                    label="Поиск"
                    single-line
                    hide-details
            ></v-text-field>
        </v-card-title>


        <!--        тАБЛИЦА-->
        <v-data-table
                show-expand
                dense
                no-data-text=""
                :headers="headers"
                :items="weatherList"
                sort-by="calories"
                :search="search"
                class="elevation-1"
                :footer-props="{
        showFirstLastPage: true,
        firstIcon: 'mdi-arrow-collapse-left',
        lastIcon: 'mdi-arrow-collapse-right',
        prevIcon: 'mdi-minus',
        nextIcon: 'mdi-plus',
          itemsPerPageText: 'Количество строк'
      }"
        >

            <template v-slot:expanded-item="{ headers, item }">
                <td :colspan="headers.length">
                    <v-simple-table>
                        <template v-slot:default>

                            <tbody>
                            <td class="subtitle-1">
                                <b>Основное:</b> {{ item.main }} <br>
                                <b>Скорость ветра:</b> {{ item.windSpeed }} <br>
                                <b>Ветренный град:</b> {{ item.windSpeed }} <br>
                                <b>Температура:</b> {{ item.temp }} <br>
                                <b>Будет чувствоваться:</b> {{ item.feelsLike }} <br>
                                <b>Давление:</b> {{ item.pressure }} <br>
                                <b>Влажность:</b> {{ item.humidity }} <br>
                                <b>Дата создания:</b> {{ item.date }} <br>
                            </td>
                            </tbody>
                        </template>
                    </v-simple-table>
                </td>

            </template>
            <template v-slot:top>
                <v-toolbar flat color="white">
                    <!--                    <v-toolbar-title>My CRUD</v-toolbar-title>-->
                    <!--                    <v-divider-->
                    <!--                            class="mx-4"-->
                    <!--                            inset-->
                    <!--                            vertical-->
                    <!--                    ></v-divider>-->

                    <v-dialog v-model="dialog" max-width="1200px">
                        <template v-slot:activator="{ on }">
                            <v-btn color="green" dark class="mb-2" v-on="on">
                                <v-icon>add_box</v-icon>
                            </v-btn>
                        </template>
                        <v-card>
                            <v-card-title>
                                <span class="headline">Поиск города</span>
                            </v-card-title>

                            <v-card-text>
                                <v-container>
                                    <country-list
                                            v-bind:add-visible="true"
                                            @save="save"
                                    ></country-list>
                                </v-container>
                            </v-card-text>

                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn color="red darken-1" text @click="close">
                                    <v-icon>backspace</v-icon>
                                </v-btn>
                                <v-btn color="blue" text @click="save">
                                    <v-icon>save</v-icon>
                                </v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>
                </v-toolbar>
            </template>
            <template v-slot:item.actions="{ item }">

                <v-icon
                        small
                        class="mr-2"
                        @click="showItem(item)"
                >
                    visible
                </v-icon>
            </template>


        </v-data-table>


    </v-card>
</template>

<script>
    import CountryList from "../dictionary/CountryList.vue";


    export default {
        name: 'WeatherList',
        components: {
            CountryList
        },
        data: () => ({
            on: '',
            search: '',
            dialog: false,
            headers: [
                {text: 'Страна', align: 'start', sortable: false, value: 'countryName',},
                {text: 'Город', value: 'cityName'},
                {text: 'Время создания', value: 'date'},
                // {text: 'Температура', value: 'countrвyCode'},
                // {text: 'Погода', value: 'fat'},

                {text: '', value: 'actions', sortable: false, width: 100},
            ],

            weatherList: [],
            cityId: '',
            filteredItem:
                {
                    countryId: '',
                    cityId: '',
                },

        }),

        computed: {
            formTitle() {
                return this.editedIndex === -1 ? 'Новая запись' : 'Изменить запись'
            },
        },

        watch: {
            dialog(val) {
                val || this.close()
            },
        },

        created() {
            this.getWeatherList()
        },

        methods: {
            getWeatherList() {
                this.$store.dispatch('GET_GENERAL_REQUEST', {
                    data: '',
                    url: '/travel/list',
                    setList: this.showWeatherList
                })

            },
            showWeatherList(rows) {
                console.log(rows),
                    this.weatherList = rows
            },

            save(cityId) {
                this.$store.dispatch('GET_GENERAL_REQUEST', {
                    data: '',
                    url: '/travel/save/'+cityId,
                    setList: this.saveSucces
                })

            },
            saveSucces(item) {
                this.getWeatherList(),
              console.log(item)
                this.dialog=false

            },
            showItem(item) {
                console.log(item)
            },


            close() {
                this.dialog = false

            },


        },

    }
</script>

<style scoped>

</style>