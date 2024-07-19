import './card.css'
import { Link } from 'react-router-dom'

function Card(props) {

  var colour = '';

  if(props.vendor == 'Netflix'){
    colour = 'text-red-500';
  }
  else if(props.vendor == 'Prime'){
    colour = 'text-blue-500';
  }
  else if(props.vendor == 'Disney'){
    colour = 'text-green-500';
  }

  return (
    <Link to= {`/show/${props.id}`}>
      <div id="card">
        <div className="movie-thumbnail">
            <img src={props.images[1].imgUrl}/>
        </div>
        <div className="movie-details">
            <div>{props.title}</div>
            <p className='text-yellow-400'>${props.price}</p>
            <p className={colour}>{props.vendor}</p>
        </div>
    </div>
    </Link>
  )
}

export default Card