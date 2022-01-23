<template>
  <div class="task-page">
    <p>
      <router-link class="logout" v-show="!loggingIn" to="/login">Logout</router-link>
    </p>
    <div class="task-wrapper">
      <div>
        <span class="task-title">PawaTask</span
        ><input type="button" @click="showFormModal" class="btn-red" value="Add a new task" />
      </div>
      <hr />

      <div v-for="task in getTasks" :key="task.id">
        <task-item :task="task" v-show="getTasks.length == 0 ? false : true" />
      </div>

      <div v-show="getTasks.length == 0 ? true : false">
        <span class="span-new">You do not have any tasks</span>
        <span class="span-red" @click="showFormModal"> add a new task</span>
      </div>
    </div>

    <task-modal v-show="isFormModalVisible" @close="closeModal" />
    <task-comment-modal v-show="isCommetModalVisible" @close="closeModal" />
  </div>
</template>
<style scoped>
.task-page {
  border-width: 0px;
  position: fixed;
  left: 0px;
  right: 0px;
  top: 0px;
  bottom: 0px;
  margin: auto;
  width: 40%;
  height: 80%;
  background-color: white;
}

.logout {
  margin-top: -2%;
  float: right;
  margin-right: 10px;
}

hr {
  margin-top: 3%;
  border-top: 0.5px solid rgb(233, 233, 233);
}

span {
  font-family: "Proxima Nova";
  font-weight: 200;
  font-style: normal;
  font-size: 13px;
  cursor: pointer;
}

.span-red {
  color: #ed4d24;
  text-decoration: underline;
}

.task-title {
  font-family: "Proxima Nova";
  font-weight: 700;
  font-style: normal;
  font-size: 24px;
  left: 0px;
}

.btn-red {
  border-width: 0px;
  position: absolute;
  right: 5%;
  width: 120px;
  height: 30px;
  font-family: "Proxima Nova";
  font-weight: 700;
  font-style: normal;
  background-color: red;
  color: #ffffff;
  cursor: pointer;
}

.task-wrapper {
  padding-right: 5%;
  padding-left: 5%;
  padding-top: 3%;
  padding-bottom: 3%;
}

@media screen and (max-width: 850px) {
  .task-page {
    width: 60%;
  }
}

@media screen and (max-width: 400px) {
  .task-page {
    width: 80%;
  }
}
</style>
<script>
import TaskCommentModal from "../shared/TaskCommentModal";
import TaskModal from "../shared/TaskFormModal";
import TaskItem from "../shared/TaskItem";

export default {
  components: {
    TaskCommentModal,
    TaskModal,
    TaskItem,
  },
  mounted() {
    this.getAllTask();
  },
  computed: {
    loggingIn() {
      return this.$store.state.authentication.status.loggingIn;
    },
    getTasks() {
      return this.$store.getters["task/getTasks"];
    },
  },
  data() {
    return {
      isFormModalVisible: false,
      isCommetModalVisible: false,
      model: {
        id: "",
        title: "",
        description: "",
        day: 0,
        month: 0,
        year: 0,
        priority: "",
        comment: "",
      },
    };
  },
  methods: {
    showFormModal() {
      this.isFormModalVisible = true;
      this.$store.commit("task/isEditable", false);
    },
    showCommentModal() {
      this.isCommetModalVisible = true;
    },
    closeModal() {
      this.isFormModalVisible = false;
      this.isCommetModalVisible = false;
      this.idEditMode = false;
    },
    getAllTask() {
      const { dispatch } = this.$store;
      dispatch("task/getAllTask");
    },
    getTaskById(id, type) {
      this.closeModal();
      const { dispatch } = this.$store;
      dispatch("comment/getAllCommentByTaskId", { id });
      dispatch("task/getTaskById", { id });
      if (type == "comment") {
        this.showCommentModal();
      } else {
        this.showFormModal();
      }
    },
  },
  getAllCommentByTaskId(id) {
    const { dispatch } = this.$store;
    dispatch("comment/getAllCommentByTaskId", { id });
  },
};
</script>
