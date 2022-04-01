import { initializeApp, getApp, getApps } from "firebase/app";

const firebaseConfig = {
  apiKey: "AIzaSyDSX15dCz4QIK8FLGcEtTr5-g7p6_DjYkw",
  authDomain: "login-register-app-empresarial.firebaseapp.com",
  projectId: "login-register-app-empresarial",
  storageBucket: "login-register-app-empresarial.appspot.com",
  messagingSenderId: "295687754215",
  appId: "1:295687754215:web:92d0a439de2c2b9825ed42"
};

const firebaseApp = !getApps().length ? initializeApp(firebaseConfig) : getApp();
export default firebaseApp;