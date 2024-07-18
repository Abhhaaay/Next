import '../index.css';
import searchImg from '../assets/search-3.svg';
import { useState, useEffect, useRef } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import _ from 'lodash';

function Header() {
  const [isVisible, setIsVisible] = useState(true);
  const [isNotVisible, setIsNotVisible] = useState(false);
  const [showName, setShowName] = useState("");
  const [releases, setReleases] = useState([]); // Initialize as an empty array

  const hide = () => {
    setIsVisible(false);
    setIsNotVisible(true);
  };

  const updateName = (event) => {
    setShowName(event.target.value);
  };

  const fetchShow = async (query) => {
    try {
      const response = await axios.get(`http://localhost:8080/movies/search/${query}`);
      setReleases(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const debouncedFetchShow = useRef(_.debounce(fetchShow, 300)).current;

  useEffect(() => {
    if (showName) {
      debouncedFetchShow(showName);
    } else {
      setReleases([]); // Clear results if input is empty
    }
  }, [showName, debouncedFetchShow]);

  return (
    <div>
      <div id="header"></div>
      <div id="header-text">
        <Link to="/" className='block'>
          <div>
            <div className="brand-name font-mono">Next</div>
          </div>
        </Link>
        <div className="options">
          <div>
            {isVisible && (
              <div onClick={hide} className='flex justify-end hover:cursor-pointer hover:-translate-x-0.5 hover:-translate-y-0.5'>
                <p className='pt-1 mr-1 text-slate-50 text-xl hover:text-orange-500'>Search</p>
                <img src={searchImg} className='size-8 pt-2' />
              </div>
            )}
            {isNotVisible && (
              <div >
                <input 
                  type='text' 
                  className='text-black rounded-md mr-2' 
                  onChange={updateName} 
                  value={showName} 
                />
                <button onClick={() => fetchShow(showName)} className='font-semibold'>Search</button>
              </div>
            )}
            <div className='result-menu max-h-96 overflow-auto'>
            {releases.length > 0 && releases.map((release) => (
              <Link key={release.id} to={`/show/${release.id}`}>
                <div className="search-result">
                  <div>
                    <img src={release.images[0].imgUrl} className='search-img' />
                  </div>
                  <div className='search-details'>
                    <h2>{release.title}</h2>
                    <p className='text-amber-500'>${release.price}</p>
                    <p>{release.rating}/5</p>
                  </div>
                </div>
              </Link>
            ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Header;