<template>


    <v-menu

            ref="fromDateMenu"
            v-model="datBDateMenu"

            :close-on-content-click="false"
            transition="scale-transition"
            offset-y
            max-width="290px"
            min-width="290px"
    >

        <template v-slot:activator="{ on }">
            <v-text-field

                    :rules="fieldRules"
                    :value="vars.value"
                    :label=vars.field_caption
                    v-mask="'##.##.#####'"
                    persistent-hint
                    :disabled="disableField"
                    clearable
                    prepend-icon="event"
                    @click:prepend="datBDateMenu=true; on"

                    @blur="datBJs = parseDate(vars.value)"

            ></v-text-field>

        </template>
        <v-date-picker
                locale="ru-in"
                v-model="datBJs"
                no-title
                @input="datBDateMenu = false">
        </v-date-picker>
    </v-menu>

</template>

<script>
    import ConvertDate from "../../util/ConvertDate";

    const convertDate = new ConvertDate()
    export default {
        props: {
            fieldRules: {
                type: Array,

            },
            disableField: {
                type: Boolean,
                default: false
            },
            vars: {
                aid: '',
                cid: '',
                field_caption: '',
                field_name: '',
                field_type: '',
                value: '',
                id: ''
            }

        },
        name: "DateComponent",
        data() {
            return {
                datBDateMenu: false,
                datBJs: '',

            }
        },
        watch: {
            datBJs() {

                this.vars.value = this.formatDate(this.datBJs)
            },
        },
        methods: {
            formatDate(date) {
                if (!date) return null
                return convertDate.fromJs(date)
            },
            parseDate(date) {
                if (!date) return null
                return convertDate.fromOracle(date)
            },
        }
    }
</script>

<style scoped>

</style>