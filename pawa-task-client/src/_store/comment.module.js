import { commentService } from "../_services/comment.service";

export const comment = {
  namespaced: true,
  state: {
    comments: [],
  },
  actions: {
    getAllCommentByTaskId({ dispatch, commit }, { id }) {
      commentService.getAllCommentByTaskId(id).then(
        (comments) => {
          commit("setComment", comments);
          return comments;
        },
        (error) => {
          console.log(error);
        }
      );
    },
    saveComment({ dispatch, commit }, { model }) {
      commentService.saveComment(model).then(
        (comment) => {
          commit("addComment", comment);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },

  mutations: {
    setComment(state, comments) {
      state.comments = comments;
      console.log(state.comments);
    },
    addComment(state, comment) {
      state.comments.push(comment);
    },
    deleteComment(state, id) {
      state.comments.splice(state.comments.map((comments) => comments.id).indexOf(id), 1);
    },
  },

  getters: {
    getAllCommentByTaskId(state) {
      return state.comments;
    },
    getTask(state) {
      return state.task;
    },
    isEditable(state) {
      return state.isEditable;
    },
  },
};
