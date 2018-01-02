'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {storylines: []};
	}

	componentDidMount() {
	    // slice "/pos" out of path
	    let position = location.pathname.slice(5);
        console.log(position);
        let path = '/api/storylines/search/findByPage?page=' + position;
        console.log(path);
        client({method: 'GET', path: path}).done(response => {
			this.setState({storylines: response.entity._embedded.storylines});
		});
	}

	render() {
		return (
			<StorylineSelection storylines={this.state.storylines}/>
		)
	}
}

class StorylineSelection extends React.Component{
	render() {
        let storylines = this.props.storylines.map(storyline =>
            <Storyline key={storyline._links.self.href} storyline={storyline}/>
        );
        return (
            <table>
				<tbody>
					<tr>
						<th>Text</th>
						<th>Position</th>
					</tr>
					{storylines}
				</tbody>
			</table>
		)
	}
}

class Storyline extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.storyline.text}</td>
				<td>{this.props.storyline.position}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
);
