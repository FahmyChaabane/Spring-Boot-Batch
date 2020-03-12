import React, { Component } from "react";
import axios from "axios";
import "./App.css";

class App extends Component {
  state = {
    data: {
      animeDTOArrayList: [],
      pagesNumber: []
    },
    currentPage: 0
  };

  componentDidMount = async () => {
    console.log("App.jsx");
    try {
      const data = (await axios.get("http://localhost:9091/anime")).data;
      this.setState({ data });
      console.log("body of the request", data);
    } catch (error) {
      console.log("something went wrong with the called server");
    }
  };

  method = async index => {
    try {
      const data = (
        await axios.get("http://localhost:9091/anime?page=" + index)
      ).data;
      this.setState({ data });
      console.log("index request response", data);
      console.log("current page", this.state.data.currentPage);
    } catch (error) {
      console.log("something went wrong with the called server");
    }
  };

  previous = async index => {
    console.log("previous");
    if (index === 0) return;
    else {
      try {
        const data = (
          await axios.get("http://localhost:9091/anime?page=" + index - 1)
        ).data;
        this.setState({ data });
        console.log("current page", this.state.data.currentPage);
        console.log("index request response", data);
      } catch (error) {
        console.log("something went wrong with the called server");
      }
    }
  };

  next = async index => {
    console.log("next");
    if (index === this.state.data.pagesNumber.length - 1) return;
    else {
      try {
        const data = (
          await axios.get("http://localhost:9091/anime?page=" + index + 1)
        ).data;
        this.setState({ data });
        this.setState({ data, currentPage: index });
        console.log("current page", this.state.data.currentPage);
      } catch (error) {
        console.log("something went wrong with the called server");
      }
    }
  };

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <p>
            Spring <code>Boot</code> pagination and http requests.
          </p>
        </header>

        <table className="table">
          <thead>
            <tr>
              <th className="text-primary">id</th>
              <th className="text-primary">title</th>
              <th className="text-primary">description</th>
            </tr>
          </thead>
          <tbody>
            {this.state.data.animeDTOArrayList.length === 0 ? (
              <code>data is loading... </code>
            ) : (
              this.state.data.animeDTOArrayList.map(el => (
                <tr key={el.id}>
                  <td>{el.id}</td>
                  <td>{el.title}</td>
                  <td>{el.description}</td>
                </tr>
              ))
            )}
          </tbody>
        </table>
        <hr />
        <nav aria-label="Page navigation">
          <ul className="pagination justify-content-center">
            <li className="page-item">
              <button
                className="page-link"
                onClick={() => this.previous(this.state.currentPage)}
              >
                Previous
              </button>
            </li>
            {this.state.data.pagesNumber.length === 0 ? (
              <button className="page-link"></button>
            ) : (
              this.state.data.pagesNumber.map((e, i) => (
                <li className="page-item" key={i}>
                  <button className="page-link" onClick={() => this.method(i)}>
                    {i + 1}
                  </button>
                </li>
              ))
            )}

            <li className="page-item">
              <button
                className="page-link"
                onClick={() => this.next(this.state.currentPage)}
              >
                Next
              </button>
            </li>
          </ul>
        </nav>
        <hr />
      </div>
    );
  }
}

export default App;
