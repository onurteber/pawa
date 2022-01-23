<template>
  <div>
    <div>
      <input type="checkbox" v-on:click="select" /> <span>{{ task.title }}</span>
      <img
        src="https://img.icons8.com/plasticine/100/000000/filled-trash.png"
        width="18px"
        v-show="this.selected"
        height="18px"
        style="float: right; margin-right: 5px"
        v-on:click="deleteTask(task.id)"
      />
      <img
        src="https://img.icons8.com/ios-filled/50/fa314a/edit-row.png"
        width="18px"
        height="18px"
        style="float: right; margin-right: 5px"
        v-on:click="editTask(task.id)"
      />
      <img
        src="https://img.icons8.com/fluency-systems-filled/48/fa314a/comments--v2.png"
        width="18px"
        height="18px"
        style="float: right; margin-right: 5px"
        v-on:click="showCommentModal(task.id)"
      />
      <span style="float: right; margin-right: 5px">{{
        (task.day.length == 1 ? 0 + task.day : task.day) +
        "/" +
        (task.month.length == 1 ? 0 + task.month : task.month) +
        "/" +
        task.year
      }}</span>
      <img
        src="https://img.icons8.com/ios/50/000000/calendar--v3.png"
        width="14px"
        height="14px"
        style="float: right; margin-right: 5px"
      />
    </div>
    <hr />
  </div>
</template>
<script>
export default {
  props: ["task"],
  data() {
    return {
      selected: false,
    };
  },
  methods: {
    select() {
      this.selected = !this.selected;
    },
    deleteTask(id) {
      const { dispatch } = this.$store;
      dispatch("task/deleteTask", { id });
    },
    editTask(id) {
      this.$parent.getTaskById(id);
    },
    showCommentModal(id) {
      this.$parent.getTaskById(id, "comment");
    },
  },
};
</script>
