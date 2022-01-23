import { authHeader } from "../_helpers";
import { router } from "../_helpers";

export const userService = {
  login,
  logout,
  register,
  router,
};

function login(username, password) {
  const requestOptions = {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ username, password }),
  };

  return fetch(`http://localhost:8082/auth/login`, requestOptions)
    .then(handleResponse)
    .then((user) => {
      if (user.token) {
        const success = "Success";
        localStorage.setItem("user", JSON.stringify(user.token));
        localStorage.setItem("username", JSON.stringify(user.userId));
        return Promise.resolve(success);
      }
    });
}

function register(username, password) {
  const requestOptions = {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ username, password }),
  };

  return fetch(`http://localhost:8082/auth/register`, requestOptions)
    .then(handleResponse)
    .then((data) => {
      const success = "Success";
      return Promise.resolve(success);
    });
}

function logout() {
  // remove user from local storage to log user out
  localStorage.removeItem("user");
  localStorage.removeItem("username");
}

function handleResponse(response) {
  return response.text().then((text) => {
    const data = text && JSON.parse(text);
    if (!response.ok) {
      if (response.status === 401) {
        logout();
      }
      const error = (data && data.message) || response.statusText;
      return Promise.reject(error);
    }
    return data;
  });
}
