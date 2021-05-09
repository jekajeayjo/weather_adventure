<template>
    <v-card class="ml-5 mr-2">

        <v-row dense>
            <v-col md="5" offset-md="1">
                <v-combobox
                        @change="getCitiesList()"
                        :items="countriesList"
                        label="Список стран"
                        prepend-icon="map"
                        v-model="filteredItem.countryId"
                        item-text="nameEn"
                ></v-combobox>
            </v-col>
            <!--            <v-col md="5">-->
            <!--                <v-combobox-->
            <!--                        prepend-icon="apartment"-->
            <!--                        :items="citiesList"-->
            <!--                        label="Список городов"-->
            <!--                        v-model="filteredItem.cityId"-->
            <!--                        item-text="nameEn"-->
            <!--                ></v-combobox>-->
            <!--            </v-col>-->
        </v-row>
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
                dense
                no-data-text=""
                :headers="headers"
                :items="citiesList"
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

            <template v-slot:item.actions="{ item }">

                <v-icon
                        v-if="addVisible==true"
                        color="green"

                        class="mr-2"
                        @click="addItem(item)"
                >
                    add_circle
                </v-icon>
            </template>


        </v-data-table>


    </v-card>
</template>

<script>

    export default {
        name: 'CountryList',
        props: {
            addVisible: {
                type: Boolean,
                required: false,
                default: false
            },

        },
        data: () => ({
            on: '',
            search: '',
            dialog: false,
            headers: [
                {text: 'Страна', align: 'start', sortable: false, value: 'nameEn',},
                {text: 'код Страны', value: 'countryCode'},

                {text: '', value: 'actions', sortable: false, width: 100},
            ],
            desserts: [],
            countriesList: [],
            citiesList: [],
            editedIndex: -1,
            filteredItem:
                {
                    countryId: '',
                    cityId: '',
                },
            editedItem: {
                name: '',
                calories: 0,
                fat: 0,
                carbs: 0,
                protein: 0,
            }
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
            this.getCountriesList()
        },

        methods: {
            getCountriesList() {
                this.$store.dispatch('GET_GENERAL_REQUEST', {
                    data: '',
                    url: '/country/all_countries',
                    setList: this.showCountriesList
                })

            },
            showCountriesList(rows) {
                console.log(rows),
                    this.countriesList = rows
            },


            getCitiesList() {
                this.$store.dispatch('GET_GENERAL_REQUEST', {
                    data: '',
                    url: '/country/city/' + this.filteredItem.countryId.id,
                    setList: this.showCitiesListList
                })
            },
            showCitiesListList(rows) {
                console.log(rows),
                    this.citiesList = rows
            },
            addItem(item) {
                this.$emit('save', item.id)
            },


            close() {
                this.dialog = false
                setTimeout(() => {
                    this.editedItem = Object.assign({}, this.defaultItem)
                    this.editedIndex = -1
                }, 300)
            },


        },

    }
</script>

<style scoped>

</style>