import { useForm } from "react-hook-form";
export default function RegisterPage() {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors },
  } = useForm();

  const submitData = (data, e) => {
    console.log(data);
    e.target.reset();
  };

  //validación de contraseña
  const password = watch("password");

  return (
    <>
      <form
        className="grid grid-cols-2 gap-y-7 gap-x-2"
        onSubmit={handleSubmit(submitData)}
      >
        <h4 className="col-span-2 font-bold">Crear cuenta</h4>

        {/* Input nombre */}
        <div className="col-span-1 relative">
          <input
            className="p-2 rounded border border-[#D4D4D8]"
            {...register("firstName", {
              required: "Nombre requerido",
              maxLength: 20,
            })}
            placeholder="Nombre"
          ></input>
          <span className="absolute top-10 -bottom-7 left-1">
            {errors?.firstName?.message}
          </span>
        </div>

        {/* Input apellido */}
        <div className="col-span-1 relative">
          <input
            className="p-2 rounded border border-[#D4D4D8]"
            {...register("lastName", {
              required: "Apellido requerido",
              maxLength: 20,
            })}
            placeholder="Apellido"
          />
          <span className="absolute top-10 -bottom-7 left-1">
            {errors?.lastName?.message}
          </span>
        </div>

        {/* Input email */}
        <div className="grid col-span-2 relative">
          <input
            className="col-span-2 p-2 rounded border border-[#D4D4D8]"
            {...register(
              "email",
              { required: "E-mail requerido" },
              { pattern: "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" }
            )}
            placeholder="E-mail"
          />
          <span className="absolute top-10 -bottom-7 left-1">
            {errors?.email?.message}
          </span>
        </div>

        {/* Input contraseña */}
        <div className="grid col-span-2 relative">
          <input
            className="col-span-2 p-2 rounded border border-[#D4D4D8]"
            name="password"
            type="password"
            {...register("password", {
              required: "Contraseña requerida",
              minLength: {
                value: 8,
                message: "Contraseña: mínimo 8 caracteres",
              },
              maxLength: {
                value: 20,
                message: "Contraseña: máximo 20 caracteres",
              },
            })}
            placeholder="Contraseña"
          />
          <span className="absolute top-10 -bottom-7 left-1">
            {errors?.password?.message}
          </span>
        </div>

        {/* Input confirmar contraseña */}
        <div className="grid col-span-2 relative">
          <input
            className="col-span-2 p-2 rounded border border-[#D4D4D8]"
            name="confirmPassword"
            type="password"
            {...register("confirmPassword", {
              required: "Contraseña requerida",
              minLength: {
                value: 8,
                message: "Contraseña: mínimo 8 caracteres",
              },
              maxLength: {
                value: 20,
                message: "Contraseña: máximo 20 caracteres",
              },
              validate: (value) =>
                value === password || "Las contraseñas no coinciden",
            })}
            placeholder="Confirmar contraseña"
          />
          <span className="absolute top-10 -bottom-7 left-1">
            {errors?.confirmPassword?.message}
          </span>
        </div>

        <button
          className="col-span-2 rounded bg-[#6D28D9] text-white"
          type="submit"
          value="submit"
        >
          Crear cuenta
        </button>
      </form>
    </>
  );
}
