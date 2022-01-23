<template>
  <div class="wrapper">
    <h2 class="title">PawaTask Login</h2>
    <form @submit.prevent="handleSubmit">
      <div class="container">
        <div>
          <label for="username">Username</label>
          <input
            type="text"
            v-model="username"
            name="username"
            :class="{ 'is-invalid': submitted && !username }"
          />
          <div v-show="submitted && !username" class="invalid-feedback">Username is required</div>
        </div>
        <div>
          <label htmlFor="password">Password</label>
          <input
            type="password"
            v-model="password"
            name="password"
            :class="{ 'is-invalid': submitted && !password }"
          />
          <div v-show="submitted && !password" class="invalid-feedback">Password is required</div>
        </div>
        <div>
          <button class="button-green" :disabled="loggingIn">Login</button>
        </div>
      </div>

      <p>
        <router-link to="/register">Register</router-link>
      </p>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      password: "",
      submitted: false,
    };
  },
  computed: {
    loggingIn() {
      return this.$store.state.authentication.status.loggingIn;
    },
  },
  created() {
    this.$store.dispatch("authentication/logout");
  },
  methods: {
    handleSubmit(e) {
      this.submitted = true;
      const { username, password } = this;
      const { dispatch } = this.$store;
      if (username && password) {
        dispatch("authentication/login", { username, password });
      }
    },
  },
};
</script>
