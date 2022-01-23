import Vue from "vue";
import Router from "vue-router";

import LoginPage from "../components/login/LoginPage";
import RegisterPage from "../components/register/RegisterPage";
import TaskPage from "../components/task/TaskPage";

Vue.use(Router);

export const router = new Router({
  routes: [
    { path: "/login", component: LoginPage },
    { path: "/register", component: RegisterPage },
    { path: "/task", component: TaskPage },
    { path: "*", redirect: "/task" },
  ],
});

router.beforeEach((to, from, next) => {
  const publicPages = ["/login", "/register"];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem("user");

  if (authRequired && !loggedIn) {
    return next("/login");
  }

  if (to.path == "/") {
    return next("/task");
  }
  next();
});
