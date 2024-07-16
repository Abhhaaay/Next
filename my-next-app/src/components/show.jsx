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
      <div id="show" className="text-white text-center my-10">
        <h1 className="text-4xl font-bold">{show.title}</h1>
        <div className="my-4">
          <img src={show.posterUrls} alt={show.title} className="w-1/4 mx-auto rounded-lg shadow-lg" />
        </div>
        <div className="text-xl">
          <p><strong>Price:</strong> ${show.price}</p>
          <p><strong>Vendor:</strong> {show.vendor}</p>
          <p><strong>Rating:</strong> {show.rating}</p>
        </div>
      </div>
    </>
  );
}

export default Show;