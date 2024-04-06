import React from 'react'
import { Header } from './Header'
import { CustomMap } from './Map/CustomMap'

export const MainContainer = () => {
  return (
    <div>
      <Header/>
      <CustomMap></CustomMap>
    </div>
  )
}
