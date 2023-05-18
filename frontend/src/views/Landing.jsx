import React from 'react'
import Header from '../components/Header'

export default function Landing() {
  return (
    <>
    <Header/>
     <div className='bg-white text-black w-full h-[89vh] flex flex-col justify-evenly items-center'>
        <img className='w-[70vw] drop-shadow-md' src='https://s3-alpha-sig.figma.com/img/7809/1e44/a5c8268a07ef3c2d41897bfbf4068424?Expires=1685318400&Signature=P~8GsJ3xHm7CnShqheS6hcWvu74SL1WIUz-lr-lE9VesRQWByF0kFheYsQDsPD2idK~~W6jxyd1lYdRNPVhI4ipjJeMkInS6hFLqYJ-FJC619riuti5DRuFTSH7LBRKZtb9CvSEUrojRMbSgLS5XQGLTVHl6aPvX2IgExEPvT0kGkIduon5fhW91RDwVoLDZnMwmpqN3S5ErZp0HXip5hk8~9Gi415q9rs-HDoqfPXOXywkgUw7vHA11f1ASzQ77TmKfj9gVbkUzRulLQUab79Jg5DQRoc7EVkkjz6STuAqDLqJjoxaxH~3faRazXLrQ6i2oe794Qp-bhNDavi7JLg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4' alt='1'></img>
        <h2 className='w-[90vw] text-[1.25em] text-center text-neutral-900 font-bold'>Lorem ipsum dolor sit amet<br/>consectetur. Lacinia imperdiet<br/>consectetur nunc a tortor quam.</h2>
        <h3 className='w-[90vw] text-[1em] text-center text-neutral-900 font-medium'>Lorem ipsum dolor sit amet consectetur.<br/>Cras facilisi quam.</h3>
        <button className='w-[90vw] h-[6vh] bg-[#6D28D9] text-white rounded-lg'>Registrarse gratis</button>
     </div>
    </>
  )
}

