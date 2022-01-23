export const taskService = {
  getAllPriority,
  saveTask,
  getAllTask,
  editTask,
  getTaskById,
  deleteTask,
};

function getAllPriority() {
  const requestOptions = {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: JSON.parse(localStorage.getItem("user")),
    },
  };
  return fetch(`http://localhost:8082/pawatask/task/getAllPriority`, requestOptions)
    .then((priorities) => priorities.json())
    .then((priorities) => {
      return priorities;
    })
    .catch((error) => alert(error));
}

function getAllTask() {
  const requestOptions = {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: JSON.parse(localStorage.getItem("user")),
    },
  };
  return fetch(`http://localhost:8082/pawatask/task`, requestOptions)
    .then((tasks) => tasks.json())
    .then((tasks) => {
      return tasks;
    })
    .catch((error) => alert(error));
}

function getTaskById(id) {
  const requestOptions = {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: JSON.parse(localStorage.getItem("user")),
    },
  };
  return fetch(`http://localhost:8082/pawatask/task/` + id, requestOptions)
    .then((task) => task.json())
    .then((task) => {
      return task;
    })
    .catch((error) => alert(error));
}

function deleteTask(id) {
  const requestOptions = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: JSON.parse(localStorage.getItem("user")),
    },
  };
  return fetch(`http://localhost:8082/pawatask/task/delete/` + id, requestOptions)
    .then((task) => task.json())
    .then((task) => {
      return task;
    })
    .catch((error) => alert(error));
}

function saveTask(model) {
  const username = JSON.parse(localStorage.getItem("username"));
  const requestOptions = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: JSON.parse(localStorage.getItem("user")),
    },
    body: JSON.stringify({
      title: model.title,
      description: model.description,
      day: model.day,
      month: model.month,
      year: model.year,
      priority: model.priority,
      comment: model.comment,
      lastUpdatedBy: username,
      createdBy: username,
    }),
  };
  return fetch(`http://localhost:8082/pawatask/task`, requestOptions)
    .then((priorities) => priorities.json())
    .then((priorities) => {
      return priorities;
    })
    .catch((error) => alert(error));
}

function editTask(model) {
  const username = JSON.parse(localStorage.getItem("username"));
  const requestOptions = {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
      Authorization: JSON.parse(localStorage.getItem("user")),
    },
    body: JSON.stringify({
      id: model.id,
      title: model.title,
      description: model.description,
      day: model.day,
      month: model.month,
      year: model.year,
      priority: model.priority,
      comment: model.comment,
      lastUpdatedBy: username,
    }),
  };
  return fetch(`http://localhost:8082/pawatask/task`, requestOptions)
    .then((priorities) => priorities.json())
    .then((priorities) => {
      return priorities;
    })
    .catch((error) => alert(error));
}
