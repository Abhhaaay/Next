
import tv from '../assets/tv-2.svg'

function about() {
  return (
      <div id="about">
        <div className="description">
          <div className='description-title'>Enjoy your favourite shows</div>
          <div className='description-brief'>
            Watch what&apos;s trending, anytime, anywhere with our entertainment platform.
          </div>
          <div className='description-brief'>
            We bring you shows from different beloved platforms such as Netflix, Prime Video, Hotstar, etc.
            All at your fingertips. 
          </div>
        </div>
        <div>
          <img src={tv} className="tv animate-bounce"/>
        </div>
      </div>
  )
}

export default about