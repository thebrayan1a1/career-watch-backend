import React from 'react'
import { Link } from 'react-router-dom'

export default function Landing() {
  return (
    <>
     <div className='bg-white text-black w-full h-[90vh] flex flex-col justify-evenly items-center'>
        <img className='w-[70vw] drop-shadow-md' src='https://s3-alpha-sig.figma.com/img/74a5/5d93/69e7bafd83dfd7b80065f0d7931c2fbc?Expires=1685318400&Signature=HPU0W0GBE8mPbZXAfIdJeVy7YRZS2XxgOYlfEjG90-UE5qpfWtYJCh~777YHzMjSnU4Y66TRXZDpayjH4zyzQcyESqByXqevJ5z~ZKyDrwEpIUdaXZqTou4GkYiMNNx22sJgRn6Zty-JLeNM2WOUhZ54jQnC~~M8NT8IDsoqrXtmK68Tvjz4kgSvPeO5v2NY~m6ajkPL7lg165ORHRJ6eVcbPJfYCTHv1xWMMesXRv09whK8nSTo221sEt8S83RTZ3-dQOYxnRbyE90U2ggtmYQxjNkTGcoJxFGzb8OR7FIyt-xJuyFU9LHsCOTL6NrI3n8W99CzIpw8DBY2keu5QA__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4' alt='1'></img>
        <h2 className='w-[90vw] text-[1.25em] text-center text-neutral-900 font-bold'>Lorem ipsum dolor sit amet<br/>consectetur. Lacinia imperdiet<br/>consectetur nunc a tortor quam.</h2>
        <h3 className='w-[90vw] text-[1em] text-center text-neutral-900 font-medium'>Lorem ipsum dolor sit amet consectetur.<br/>Cras facilisi quam.</h3>
        <Link to={'login'}><button className='w-[90vw] h-[6vh] bg-[#6D28D9] text-white font-normal rounded-lg'>Registrarse gratis</button></Link>
     </div>
    </>
  )
}

