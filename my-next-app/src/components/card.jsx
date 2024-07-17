
import { Link } from 'react-router-dom'

function Card(props) {
  return (
    <Link to= {`/show/${props.id}`}>
      <div id="card">
        <div className="movie-thumbnail">
            <img src={props.images[1].imgUrl}/>
        </div>
        <div className="movie-details">
            <div>{props.title}</div>
            <p>{props.type}</p>
            <p className='price'>${props.price}</p>
            <p className='text-white'>{props.vendor}</p>
        </div>
    </div>
    </Link>
  )
}

export default Card