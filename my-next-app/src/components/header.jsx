 
import '../index.css';
import searchImg from '../assets/search.svg'
import { useState } from 'react';
import axios from 'axios'
import { Link } from 'react-router-dom'

function Header() {

  const [isVisible, setIsVisible] = useState(true);
  const [isNotVisible, setIsNotVisible] = useState(false);
  const [showName, setShowName] = useState("");
  const [release, setRelease] = useState();

  function hide(){
    setIsVisible(false);
    setIsNotVisible(true);
  }

  function updateName(event){
    setShowName(event.target.value);
  }

  function search(){
    const fetchShow = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/movie/title/${showName}`);
        setRelease(response.data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchShow();
  }

  return (
    <div>
      <div id="header"></div>
      <div id="header-text">
        <div>
          <div className="brand-logo"></div>
          <div className="brand-name font-mono">Next</div>
        </div>
        <div className="options">
            <div>
              {isVisible && (
                <div onClick={hide}>
                  <img src={searchImg} className='size-5'/>
                </div>
              )}
              {isNotVisible && (
                <div>
                  <input type='text' className='text-black ' onChange={updateName}/>
                  <button onClick={search}>Search</button>
                </div>
              )}
            </div>
            {release && (
              <Link to={`/show/${release.id}`} className='block'>
                  <div className="search-result">
                    <div>
                        <img src={release.images[0].imgUrl} className='search-img'/>
                    </div>
                    <div className='search-details'>
                      <h2>{release.title}</h2>
                      <p className='text-amber-500'>${release.price}</p>
                      <p>{release.rating}/5</p>
                    </div>
                  </div>
              </Link>
            )}
        </div>
      </div>
    </div>
  );
}

export default Header;