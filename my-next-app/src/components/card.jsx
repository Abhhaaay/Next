
import { Link } from 'react-router-dom'

function Card(props) {
  return (
    <Link to= {`/show/${props.id}`}>
      <div id="card">
        <div className="movie-thumbnail">
            <img src={props.poster_url} />
        </div>
        <div className="movie-details">
            <div>{props.title}</div>
            <p>{props.type}</p>
            <p className='price'>${props.price}</p>
            <p>{props.vendor}</p>
        </div>
    </div>
    </Link>
  )
}

export default Card