import { relative } from 'path'
import React, { useEffect, useState } from 'react'
import { MapContainer, TileLayer, Marker } from 'react-leaflet'
import "leaflet/dist/leaflet.css";
import Leaflet from "leaflet";
import * as MapConfigs from './MapConfigs'
import { CustomMarker } from './CustomMarker';
import { GetWithoutAuth } from '../../service/HttpService';
import { collapseTextChangeRangesAcrossMultipleVersions } from 'typescript';
import { Earthquake } from '../../types';


export const CustomMap = () => {


  const [earthquakes, setEarthquakes] = useState<Earthquake[]>([])

  const [center, setCenter] = useState({ lat: 51.505, lng: -0.09 })
  const [zoomLevel, setZoomLevel] = useState(3)

  const getEarthquakes = () => {
    GetWithoutAuth("http://localhost:8080/earthquake")
    .then(res => {
      if (!res.ok) {
          throw new Error('Network response was not ok');
      }
      return res.json();
  })
  .then(data => {
      // Gelen veriyi işle
      console.log(data)
      const tempData: Earthquake[] = data.data
      setEarthquakes(tempData);
  })
  .catch(error => {
      console.error('There was a problem with the fetch operation:', error);
  });
  }

  const handleInitializeMarkers = () => {
    getEarthquakes()
    console.log('test')
  }

  useEffect(() => {
    handleInitializeMarkers()
    setInterval(() => {
      handleInitializeMarkers()
    },3000)
  },[])

  return (
    <div>
      <MapContainer
        style={{ width: 100 + "%", height: 600 + 'px' }}
        center={[51.505, -0.09]}
        zoom={zoomLevel}
        scrollWheelZoom={false}>
        <TileLayer
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />

        {
          earthquakes.map((eq) => (
            <CustomMarker key={eq.id} id={eq.id} lat={eq.lat} lng={eq.lng} pow={eq.pow} depth={eq.depth} created_at={eq.created_at}></CustomMarker>
          ))
        }
      </MapContainer>
    </div>
  )
}
