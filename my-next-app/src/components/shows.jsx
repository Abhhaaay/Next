
import axios from 'axios'
import Card from './card'
import {useEffect, useState } from 'react';

function Shows() {
  const [releases, setReleases]= useState([]);
  
  useEffect(() => {
    const fetchMovies = async () => {
      try {
        const response = await axios.get('http://localhost:8080/movie');
        console.log(response.data);
        setReleases(response.data);
      } catch (error) {
        console.log(error);
      }
    };

    fetchMovies();
  }, []);



  return (
    <div id="shows">
        <div className="shows-desc text-white text-center font-bold text-xl">
            These are the current top shows, collected specially for you:
        </div>
        <div className="shows-list">
          {
            releases.map(release => 
            <Card key={release.id} id={release.id} title={release.title}
            price={release.price} vendor={release.vendor} rating={release.rating}
            images={release.images} />
            )
          }
        </div>
    </div>
  )
}

export default Shows