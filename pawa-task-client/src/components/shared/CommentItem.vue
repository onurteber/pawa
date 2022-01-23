<template>
  <div>
    <div v-for="comment in myValue" :key="comment.id">
      <div>
        <span class="createdby">{{ comment.createdBy }}</span>
        <span>{{ new Date(comment.createDate).toLocaleDateString("en-US", options) }}</span>
      </div>
      <div>
        {{ comment.content }}
      </div>
    </div>
  </div>
</template>
<style scoped>
.createdby {
  font-family: "Proxima Nova";
  font-weight: 700;
  font-style: normal;
  font-size: 18px;
  left: 0px;
}
</style>
<script>
export default {
  computed: {
    myValue() {
      return this.$store.getters["comment/getAllCommentByTaskId"];
    },
    options() {
      return { weekday: "long", year: "numeric", month: "long", day: "numeric" };
    },
  },
  methods: {
    getDate() {
      let taskDate = new Date(comment.createDate);
      let now = Date.now;
      if (taskDate.year == now.year && taskDate.month == now.month && taskDate.day == now.day) {
      }
    },
  },
};
</script>
