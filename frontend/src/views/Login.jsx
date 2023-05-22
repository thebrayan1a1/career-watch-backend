import React from "react";
import "../styles/inputLabel.css";
import '../styles/fontLogo.css'

export default function Login() {
  return (
    <>
      <main className="w-[100vw] h-[90vh] bg-white text-neutral-900">
        <h1 className="text-[4em] text-neutral-600 font-normal antialiased ml-[3vw]">
          Career<span className="text-orange-600">Watch</span>
        </h1>
        <label htmlFor="user">Username </label>
        <input type="text" id="user" />
        <label htmlFor="password">Password </label>
        <input type="password" id="password" />
        <button className="w-[90vw] h-[6vh] bg-[#6D28D9] text-white font-normal rounded-lg">
          Iniciar sesión
        </button>
        <input type="checkbox" id="remember"/>
        <label htmlFor="remember"> Recordar mi contraseña</label>
        <p className="underline">Olvide mi contraseña</p>
      </main>
    </>
  );
}
