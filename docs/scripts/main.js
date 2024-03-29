'use strict';

class Solution extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: props.id,
            name: props.name,
            level: props.level,
            rating: props.rating,
            hint: props.hint,
            questionLink: props.questionLink,
            solutionLink: props.solutionLink,
        }
    }

    render() {
        return (
                <tr>
                    <td>{ this.state.id }</td>
                    <td>{ this.state.name }</td>
                    <td>{ this.state.level }</td>
                    <td>{ this.state.rating }</td>
                    <td>{ this.state.hint }</td>
                    <td><a href={ this.state.questionLink }>Question</a></td>
                    <td><a href={ this.state.solutionLink }>Solution</a></td>
                </tr>
        );
    }
}

class QuestionList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            sortKey: "id",
            sorted: [],
            total: 0
        }

        this.getSolutions = this.getSolutions.bind(this)
        this.sortById = this.sortById.bind(this)
        this.sortByDifficulty = this.sortByDifficulty.bind(this)
        this.sortByRating = this.sortByRating.bind(this)
    }

    getSolutions() {
        const solutions = []
        for (const key in LeetcodeSolutionList) {
            const s = LeetcodeSolutionList[key]

            const paths = s.link.split("/").filter( p => p.length>0 )
            const lastPath = paths[paths.length-1]
            const name = lastPath.split("-").filter( p=>p.length>0 ).join(" ")
            s["name"] = name

            solutions.push(s)
        }
        return solutions
    }

    sortById() {
        const solutions = this.getSolutions()
        solutions.sort(function(v1, v2) {
            return v1["id"] - v2["id"]
        })
        this.setState({
            sortKey: "id",
            sorted: [],
            total: solutions.length
        }, () => {
            this.setState({
                sorted: solutions
            });
        })
    }

    sortByDifficulty() {
        const levelMap = {
            "EASY": 1,
            "MEDIUM": 2,
            "HARD": 3
        }
        const solutions = this.getSolutions()
        solutions.sort(function(v1, v2) {
            return levelMap[v1["level"]] - levelMap[v2["level"]]
        })
        this.setState({
            sortKey: "level",
            sorted: [],
            total: solutions.length
        }, () => {
            this.setState({
                sorted: solutions
            });
        })
    }

    sortByRating() {
        const solutions = this.getSolutions()
        solutions.sort(function(v1, v2) {
            return v1["rating"] - v2["rating"]
        })
        this.setState({
            sortKey: "rating",
            sorted: [],
            total: solutions.length
        }, () => {
            this.setState({
                sorted: solutions
            });
        })
    }

    componentWillMount() {
        this.sortById()
    }

    render() {
        return (
            <div>
                Daily Leetcode Solution in Kotlin<br/>
                Total: { this.state.total }<br/>
                <span style={{fontColor: 'white', fontSize: '12px'}}>* Elo rating is from the unofficial <a href={"https://zerotrac.github.io/leetcode_problem_rating"}>Leetcode Elo Rating</a></span>
               <table>
                   <thead>
                       <tr>
                           <td><button type="button" onClick={this.sortById}>ID(↑)</button></td>
                           <td>Title</td>
                           <td><button type="button" onClick={this.sortByDifficulty}>Difficulty(↑)</button></td>
                           <td><button type="button" onClick={this.sortByRating}>ELO RATING(↑)</button></td>
                           <td>Hint</td>
                           <td>Question Link</td>
                           <td>Solution Link</td>
                       </tr>
                   </thead>
                   <tbody>
                       {
                           this.state.sorted.map(solution =>
                               <Solution id={solution["id"]}
                                         name={solution["name"]}
                                         level={solution["level"]}
                                         rating={solution["rating"]}
                                         hint={solution["hint"]}
                                         questionLink={solution.link}
                                         solutionLink = {"https://github.com/likexx/leetcode-kotlin/blob/main/app/src/main/kotlin/solution/Solution" + solution["id"] + ".kt"}
                               />
                           )
                       }
                   </tbody>
               </table>
            </div>
        )
    }
}


const mainContainer = document.getElementById('main_container');
const root = ReactDOM.createRoot(mainContainer);
root.render(<QuestionList />);