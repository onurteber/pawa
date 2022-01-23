import Vue from "vue";
import Vuex from "vuex";

import { authentication } from "./authentication.module";
import { users } from "./users.module";
import { task } from "./task.module";
import { comment } from "./comment.module";

Vue.use(Vuex);

export const store = new Vuex.Store({
  modules: {
    authentication,
    task,
    users,
    comment,
  },
});
