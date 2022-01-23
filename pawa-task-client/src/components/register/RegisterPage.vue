<template>
  <div class="wrapper">
    <h2 class="title">PawaTask Register</h2>
    <form @submit.prevent="handleSubmit">
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
        <button class="button-green" :disabled="register">Register</button>
      </div>
      <p>
        <router-link to="/login">Login</router-link>
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
    register() {
      return this.$store.state.authentication.status.register;
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
        dispatch("authentication/register", { username, password });
      }
    },
  },
};
</script>
