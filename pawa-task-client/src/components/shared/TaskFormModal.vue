<template>
  <div class="modal-backdrop">
    <div class="modal">
      <header class="modal-header">
        <span name="header"> {{ isNew ? "New task" : model.title }} </span>
        <button type="button" class="btn-close" @click="close">x</button>
      </header>
      <form @submit.prevent="saveTask(model.id)">
        <section class="modal-body">
          <div class="container">
            <div>
              <label for="title">Title</label>
              <input
                type="text"
                v-model="model.title"
                name="title"
                :class="{ 'is-invalid': submitted && !model.title }"
              />
            </div>
            <div>
              <label htmlFor="description">Description</label>
              <textarea
                type="text"
                v-model="model.description"
                name="description"
                :class="{ 'is-invalid': submitted && !model.description }"
              />
            </div>
            <div>
              <label class="lbl-padding-5" for="dueDate">Set due date</label>
              <div>
                <input
                  min="1"
                  max="31"
                  class="date-input"
                  type="number"
                  v-model="model.day"
                  name="day"
                  :class="{ 'is-invalid': submitted && !model.day }"
                />
                <input
                  min="1"
                  max="12"
                  type="number"
                  class="date-input"
                  v-model="model.month"
                  name="month"
                  :class="{ 'is-invalid': submitted && !model.month }"
                />
                <input
                  min="minDate"
                  type="number"
                  class="date-input"
                  v-model="model.year"
                  name="year"
                  :class="{ 'is-invalid': submitted && !model.year }"
                />
              </div>
            </div>
            <div>
              <label class="lbl-padding-5" for="priority">Priority</label>
              <select class="priority" v-model="model.priority">
                <option
                  v-for="priority in this.$store.state.task.priorities"
                  v-bind:value="priority"
                  v-bind:key="priority"
                >
                  {{ priority }}
                </option>
              </select>
            </div>
            <div>
              <label class="lbl-padding-5" htmlFor="description">Comment</label>
              <textarea type="text" v-model="model.comment" name="comment" />
            </div>
          </div>
          <button class="submit-btn">
            {{ isNew ? "Add a new Task" : "Edit" }}
          </button>
        </section>
      </form>
    </div>
  </div>
</template>
<style scoped>
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
  flex-direction: column;
  width: 80%;
  height: 72%;
  max-width: 700px !important;
}
.modal-header {
  padding: 15px;
  display: flex;
  border-top: 1px solid #eeeeee;
}

.modal-header {
  position: relative;
  border-bottom: 1px solid #eeeeee;
  justify-content: space-between;
  font-family: "Proxima Nova";
  font-weight: 700;
  font-style: normal;
  font-size: 24px;
}

.modal-body {
  position: relative;
  padding: 20px 10px;
  height: 75%;
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

.submit-btn {
  border-width: 0px;
  width: 120px;
  height: 30px;
  font-family: "Proxima Nova";
  font-weight: 700;
  font-style: normal;
  background-color: red;
  color: #ffffff;
  cursor: pointer;
  float: right;
}

@media screen and (max-width: 1000px) {
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
  .modal-body {
    height: 60%;
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

@media screen and (min-width: 1800px) {
  .modal {
    height: 55% !important;
  }
}
</style>

<script>
export default {
  name: "Modal",
  data() {
    return {
      submitted: false,
      priorities: [],
    };
  },
  computed: {
    isNew() {
      return this.$store.getters["task/getTask"].id != "" ? false : true;
    },
    model() {
      return this.$store.getters["task/getTask"];
    },
  },
  created() {
    this.getAllPriority();
  },
  methods: {
    close() {
      this.$emit("close");
    },
    getAllPriority() {
      const { dispatch } = this.$store;
      dispatch("task/getAllPriorities");
    },
    saveTask(id) {
      const { model } = this;
      let duedate = new Date(
        model.month
          .concat("/")
          .concat(model.day)
          .concat("/")
          .concat(model.year)
          .replace(/(\d{2})-(\d{2})-(\d{4})/, "$2/$1/$3")
      );
      if (!this.checkDate(new Date(), duedate)) {
        alert("Due date should not less than now.");
      } else {
        if (this.isValid()) {
          if (id === "") {
            this.submitted = true;
            const { dispatch } = this.$store;
            dispatch("task/saveTask", { model });
          } else {
            this.submitted = true;
            const { dispatch } = this.$store;
            dispatch("task/editTask", { model });
          }
          this.close();
        }
      }
    },
    isValid() {
      const { model } = this;
      if (model.title == "" || model.description == "" || model.priority == "") {
        alert("Title, Description, Priority cannot be blank!!");
        return false;
      }
      return true;
    },
    checkDate(date1, date2) {
      if (date2.getYear() > date1.getYear()) {
        return true;
      } else if (date2.getYear() == date1.getYear()) {
        if (date2.getMonth() == date1.getMonth()) {
          if (date2.getDay() >= date1.getDay()) {
            return true;
          } else {
            return false;
          }
        } else if (date2.getMonth() > date1.getMonth()) {
          return true;
        }
      }
      return false;
    },
  },
};
</script>
