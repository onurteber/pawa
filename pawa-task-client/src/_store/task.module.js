import { taskService } from "../_services/task.service";

const taskModel = {
  id: "",
  title: "",
  description: "",
  day: 0,
  month: 0,
  year: 0,
  priority: "",
  comment: "",
};

export const task = {
  namespaced: true,
  showWarning: false,
  isEditable: false,
  state: {
    priorities: [],
    tasks: [],
    task: taskModel,
  },
  actions: {
    getAllPriorities({ dispatch, commit }) {
      taskService.getAllPriority().then(
        (priorities) => {
          commit("prioritySuccess", priorities);
          return priorities;
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getAllTask({ dispatch, commit }) {
      taskService.getAllTask().then(
        (tasks) => {
          commit("getAllTaskSuccess", tasks);
          commit("setTask", taskModel);
          return tasks;
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getTaskById({ dispatch, commit }, { id }) {
      taskService.getTaskById(id).then(
        (task) => {
          commit("setTask", task);
          commit("isEditable", true);
          return task;
        },
        (error) => {
          console.log(error);
        }
      );
    },
    saveTask({ dispatch, commit }, { model }) {
      taskService.saveTask(model).then(
        (task) => {
          commit("addTask", task);
          commit("clearTask", taskModel);
        },
        (error) => {
          commit("setTask", taskModel);
          console.log(error);
        }
      );
    },
    deleteTask({ dispatch, commit }, { id }) {
      taskService.deleteTask(id).then(
        (task) => {
          commit("deleteTask", task);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    editTask({ dispatch, commit }, { model }) {
      taskService.editTask(model).then(
        (task) => {
          commit("deleteTask", task.id);
          commit("addTask", task);
          commit("clearTask", taskModel);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },

  mutations: {
    prioritySuccess(state, priorities) {
      state.priorities = priorities;
    },
    getAllTaskSuccess(state, tasks) {
      state.tasks = tasks;
    },
    setTask(state, task) {
      state.task = task;
    },
    clearTask(state) {
      state.task = {
        id: "",
        title: "",
        description: "",
        day: 0,
        month: 0,
        year: 0,
        priority: "",
        comment: "",
      };
    },
    addTask(state, model) {
      state.tasks.push(model);
    },
    deleteTask(state, task) {
      state.tasks.splice(state.tasks.map((task) => task.id).indexOf(task.id), 1);
    },
    isEditable(state, value) {
      state.isEditable = value;
    },
  },

  getters: {
    getTasks(state) {
      return state.tasks;
    },
    getTask(state) {
      return state.task;
    },
    isEditable(state) {
      return state.isEditable;
    },
  },
};
