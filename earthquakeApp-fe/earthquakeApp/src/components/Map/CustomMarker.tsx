import React, { useState, useEffect } from 'react'
import Leaflet, { LatLng } from 'leaflet'
import { Circle, Marker, Popup } from 'react-leaflet'

import './map.css'
import { Earthquake } from '../../types'

export const CustomMarker: React.FC<Earthquake> = ( earthquake: Earthquake ) => {

  const [radius, setRadius] = useState(10);
  const [opacity, setOpacity] = useState(100);

  useEffect(() => {
  },[radius])
  
  const markerIcon = new Leaflet.Icon({
    iconUrl: require("./icon/testIcon.png"),
    iconSize: [40, 40]
  })

  return (
    <div>
      <Marker position={[earthquake.lat,earthquake.lng]} icon={markerIcon}>
          <Popup>
            <div className='marker-container'>
              <div className='marker-top'>
                <h5 className='marker-title'>Deprem Bilgileri</h5>
              </div>
              <hr></hr>
              
              <div className='marker-bottom'>
                <p className='marker-bottom-p'>
                  Enlem : {earthquake.lat}
                </p>

                <p className='marker-bottom-p'>
                  Boylam : {earthquake.lng}
                </p>

                <p className='marker-bottom-p'>
                  Deprem Büyüklüğü : {earthquake.pow}
                </p>

                <p className='marker-bottom-p'>
                  Deprem Derinliği : {earthquake.depth}
                </p>

                <p className='marker-bottom-p'>
                  Deprem Tarihi : {earthquake.created_at.toLocaleString()}
                </p>
              </div>
              
            </div>
          </Popup>
        </Marker>
    </div>
  )
}

interface CustomMarkerProps {
  lat: number,
  lng: number
}