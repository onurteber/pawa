<template>
  <div class="modal-backdrop">
    <div class="modal">
      <header class="modal-header">
        <span name="header">&#60;{{ model.title }}&#62; </span>
        <span class="span-red" @click="editTask(model.id)"> Edit task</span>
        <button type="button" class="btn-close" @click="close">x</button>
      </header>
      <div class="modal-body">
        <div class="container-body">
          <label>{{ model.description }}</label>
          <div style="display: grid">
            <div class="mrgn-top-25">
              <span style="float: left">
                Date:
                {{
                  (model.day.length == 1 ? 0 + model.day : model.day) +
                  "/" +
                  (model.month.length == 1 ? 0 + model.month : model.month) +
                  "/" +
                  model.year
                }}
              </span>
              <span style="float: right">Priority: {{ model.priority }}</span>
            </div>
            <div>
              <span>
                <div
                  class="mrgn-top-25"
                  style="border-bottom: 1px solid rgb(217 217 217); width: 100%"
                ></div>
              </span>
            </div>
          </div>
        </div>
      </div>
      <section class="modal-comment-body">
        <div class="comment-body">
          <comment-item :comments="model.comments" />
        </div>
      </section>
      <section class="modal-footer">
        <div class="container">
          <input
            type="text"
            class="input-comment"
            placeholder="Write a comment"
            v-model="comment"
            name="comment"
          />
          <button class="submit-btn" @click="saveComment(model.id)">Add Comment</button>
        </div>
      </section>
    </div>
  </div>
</template>
<style scoped>
.mrgn-top-25 {
  margin-top: 32px;
}

.modal-comment-body {
  height: 40%;
  padding: 10px;
  max-height: calc(100%-75px) !important;
}

.comment-body {
  max-height: 95%;
  overflow-y: scroll;
}

.input-comment {
  width: calc(100% - 160px) !important;
  height: 20px !important;
  margin-bottom: 2%;
  margin: 22px 0;
  margin-left: 3%;
}
.span-red {
  color: #ed4d24;
  text-decoration: underline;
  font-family: "Proxima Nova";
  font-weight: 200;
  font-style: normal;
  font-size: 13px;
  cursor: pointer;
  margin-top: 5px;
  margin-left: 10px;
}

.modal-footer {
  z-index: 9999999;
  color: white;
  text-align: center;
  position: relative;
  background-color: rgba(240, 240, 240, 1) !important;
}

.container-body {
  padding: 10px;
}

.modal-backdrop {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.3);
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 5px;
  overflow: hidden;
}

.date-input {
  text-align: center;
  width: 16%;
  outline: none;
  height: 21px;
  border: 1px solid #ccc;
}

.priority {
  left: 0px;
  width: 240px;
  height: 30px;
  font-family: "ArialMT", "Arial";
  font-weight: 400;
  font-style: normal;
  outline: none;
  font-size: 13px;
  text-decoration: none;
  color: #000000;
  border-radius: 5px;
}

.lbl-padding-5 {
  padding: 5px 0px 2px 0px;
  display: flow-root;
  margin-top: 5px;
}

.modal {
  background: #ffffff;
  box-shadow: 2px 2px 20px 1px;
  overflow-x: auto;
  display: flex;
  height: 70%;
  width: 45%;
  max-width: 700px;
  flex-direction: column;
  overflow: hidden;
}
.modal-header {
  padding: 15px;
  display: flex;
  border-top: 1px solid #eeeeee;
  max-height: 100px;
}

.modal-header {
  position: relative;
  border-bottom: 1px solid #eeeeee;
  font-family: "Proxima Nova";
  font-weight: 700;
  font-style: normal;
  font-size: 24px;
}

.modal-body {
  position: relative;
  padding: 20px 10px;
  height: 100%;
  max-height: 120px;
  font-family: "Proxima Nova";
  font-weight: 200;
  font-style: normal;
  font-size: 15px;
}

.btn-close {
  position: absolute;
  top: 5px;
  border: none;
  font-size: 20px;
  padding: 10px;
  cursor: pointer;
  font-weight: bold;
  color: black;
  background: transparent;
  right: 5%;
  width: 20px;
}

.modal-backdrop {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.3);
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 5px;
}

.submit-btn {
  border-radius: 5px;
  border-width: 0px;
  width: 120px;
  height: 30px;
  font-family: "Proxima Nova";
  font-weight: 700;
  font-style: normal;
  background-color: red;
  color: #ffffff;
  cursor: pointer;
}

@media screen and (max-width: 1000px) {
  .input-comment {
    width: calc(100% - 160px) !important;
    height: 20px !important;
    margin-bottom: 2%;
    margin-left: 3%;
  }
  .modal-body {
    height: 100%;
  }

  .date-input {
    width: 20%;
  }

  .priority {
    margin-top: 10px;
    margin-left: 1px;
    width: 160px;
    height: 30px;
    font-family: "ArialMT", "Arial";
    font-weight: 400;
    font-style: normal;
    font-size: 13px;
    text-decoration: none;
    color: #000000;
  }
}

@media screen and (min-height: 900px) {
  .modal {
    height: 55%;
  }
  .modal-comment-body {
    padding: 10px;
    max-height: calc(100%-75px) !important;
  }
}

@media screen and (min-height: 1150px) {
  .modal {
    height: 60%;
  }
}
</style>

<script>
import CommentItem from "./CommentItem";
export default {
  components: { CommentItem },
  name: "Modal",
  data() {
    return {
      comment: "",
    };
  },
  computed: {
    model() {
      return this.$store.getters["task/getTask"];
    },
  },
  methods: {
    saveComment(taskId) {
      let { comment } = this;
      const { dispatch } = this.$store;
      if (comment.trim().length > 0) {
        let model = { content: comment, taskId: taskId };
        dispatch("comment/saveComment", { model });
      }
      this.comment = "";
    },
    editTask(id) {
      this.$parent.getTaskById(id);
    },
    close() {
      this.$emit("close");
    },
  },
};
</script>
