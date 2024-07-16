 
import '../index.css';

function Header() {

  const scrollToShows = () => {
    const element = document.getElementById('shows');
    element.scrollIntoView({ behavior: 'smooth' });
  };

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
            <a href="#shows" onClick={scrollToShows}>Shows and Movies</a>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Header;