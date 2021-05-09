<template>
    <v-app-bar

app
            light
            color="white"
    >
        <router-link to="/">   <div class="d-flex align-center" >
            <v-img
                    alt="Vuetify Logo"
                    class="shrink mr-2 image-logo"
                    contain
                    src="../static/images/logo.png"
                    transition="scale-transition"
                    width="165"
                    height="60"
            />
        </div>
        </router-link>
        <v-spacer></v-spacer>

        <v-spacer></v-spacer>

        <v-btn text @click.prevent="logout">
            <span class="mr-2">Выход</span>
            <v-icon>sensor_door</v-icon>
        </v-btn>
    </v-app-bar>
</template>

<script>
    export default {
        name: "HeaderMenu",
        methods:{
            logout(){
                this.$store.dispatch('SIGN_OUT')
                this.$router.push("/login")
            }
        }
    }
</script>

<style scoped>
.image-logo{
    /*background-image: url("images/logo.png");*/
    content: url('../../../resources/static/images/logo.png');
}
</style>