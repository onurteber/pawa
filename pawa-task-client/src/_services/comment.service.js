export const commentService = {
  getAllCommentByTaskId,
  saveComment,
};

function getAllCommentByTaskId(id) {
  const requestOptions = {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: JSON.parse(localStorage.getItem("user")),
    },
  };
  return fetch(`http://localhost:8082/pawatask/comment/` + id, requestOptions)
    .then((task) => task.json())
    .then((task) => {
      return task;
    })
    .catch((error) => alert(error));
}

function saveComment(model) {
  const username = JSON.parse(localStorage.getItem("username"));
  const requestOptions = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: JSON.parse(localStorage.getItem("user")),
    },
    body: JSON.stringify({
      taskId: model.taskId,
      content: model.content,
      createdBy: username,
    }),
  };
  return fetch(`http://localhost:8082/pawatask/comment`, requestOptions)
    .then((priorities) => priorities.json())
    .then((priorities) => {
      return priorities;
    })
    .catch((error) => alert(error));
}
