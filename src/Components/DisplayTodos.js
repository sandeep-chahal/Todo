import React, { Component } from "react";

import Service from "../Service/Service";

class DisplayTodos extends Component {
  constructor(props) {
    super(props);
    this.state = {
      Todos: [],
    };
  }
  componentDidMount() {
    Service.getTodos().then((response) => {
      this.setState({ Todos: response.data });
    });
  }

  render() {
    return (
      <div style={{ fontFamily: "cursive" }}  >
          <div>
            <h1 className="text-center">Todos List</h1>
          </div>
          <div className = "row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th>Todo Id</th>
                <th>Todo Task</th>
                <th>Todo Discription</th>
                <th>Todo Date</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {this.state.Todos.map((todos) => (
                <tr key={todos.id}>
                    <td>{todos.id}</td>
                  <td>{todos.task}</td>
                  <td>{todos.description}</td>
                  <td>{todos.date}</td>
                  <td>
                      <button className = "bg-warning">
                        Update 
                      </button>
                      <button className = "bg-danger ml-3   ">
                        Delete 
                      </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
          </div>
        </div>
    );
  }
}
export default DisplayTodos;
