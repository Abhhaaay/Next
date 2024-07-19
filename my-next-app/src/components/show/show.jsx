import Header from '../header/header';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import { Carousel } from 'antd';
import './show.css'

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
        <div>
          <Carousel arrows infinite={false}>
            {show.images.map((image) => (
              <div key={image.id} className='flex w-10 justify-center'>
                <img style={{ height: '24rem', margin: '0 37%', width: '20rem' }} alt="sample_file" src={image.imgUrl} 
                className='shadow-[-5px_0px_10px_2px_#718096]'/>
              </div>
            ))}
          </Carousel>
        </div>
        <h1 className="text-5xl font-bold text-red-600 mb-4 mt-4">{show.title}</h1>
        <div className="text-xl text-white">
          <p><strong>Price:</strong> ${show.price}</p>
          <p><strong>Rating:</strong> {show.rating}/5</p>
        </div>
      </div>
    </>
  );
}

export default Show;