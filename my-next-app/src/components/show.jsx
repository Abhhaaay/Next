import Header from './header';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

function Show() {
  const [show, setShow] = useState(null);
  const { id } = useParams();

  useEffect(() => {
    const fetchShow = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/movie/${id}`);
        setShow(response.data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchShow();
  }, [id]);

  if (!show) return <div>Loading...</div>;

  return (
    <>
      <Header />
      <div id="show" className="text-center my-10">
        <div className='images-slide flex justify-center'>
          <img src={show.images[0].imgUrl} className='img-show'/>
          <img src={show.images[1].imgUrl} className='img-show'/>
          <img src={show.images[2].imgUrl} className='img-show'/>
        </div>
        <h1 className="text-5xl font-bold text-red-600 mb-4">{show.title}</h1>
        <div className="text-xl text-white">
          <p><strong>Price:</strong> ${show.price}</p>
          <p><strong>Rating:</strong> {show.rating}/5</p>
        </div>
      </div>
    </>
  );
}

export default Show;