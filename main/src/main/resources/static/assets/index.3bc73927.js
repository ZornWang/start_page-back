import{o as u,c as d,r as f,a as p,b as m,d as _}from"./vendor.20d16b53.js";const h=function(){const s=document.createElement("link").relList;if(s&&s.supports&&s.supports("modulepreload"))return;for(const e of document.querySelectorAll('link[rel="modulepreload"]'))t(e);new MutationObserver(e=>{for(const r of e)if(r.type==="childList")for(const o of r.addedNodes)o.tagName==="LINK"&&o.rel==="modulepreload"&&t(o)}).observe(document,{childList:!0,subtree:!0});function n(e){const r={};return e.integrity&&(r.integrity=e.integrity),e.referrerpolicy&&(r.referrerPolicy=e.referrerpolicy),e.crossorigin==="use-credentials"?r.credentials="include":e.crossorigin==="anonymous"?r.credentials="omit":r.credentials="same-origin",r}function t(e){if(e.ep)return;e.ep=!0;const r=n(e);fetch(e.href,r)}};h();var v=(i,s)=>{const n=i.__vccOpts||i;for(const[t,e]of s)n[t]=e;return n};const y={};function g(i,s){const n=f("router-view");return u(),d(n)}var x=v(y,[["render",g]]);const L="modulepreload",c={},b="./",O=function(s,n){return!n||n.length===0?s():Promise.all(n.map(t=>{if(t=`${b}${t}`,t in c)return;c[t]=!0;const e=t.endsWith(".css"),r=e?'[rel="stylesheet"]':"";if(document.querySelector(`link[href="${t}"]${r}`))return;const o=document.createElement("link");if(o.rel=e?"stylesheet":L,e||(o.as="script",o.crossOrigin=""),o.href=t,document.head.appendChild(o),e)return new Promise((a,l)=>{o.addEventListener("load",a),o.addEventListener("error",l)})})).then(()=>s())},k=p({history:m(),routes:[{path:"/",redirect:"/index"},{path:"/index",name:"index",component:()=>O(()=>import("./index.5b3e3a57.js"),["assets/index.5b3e3a57.js","assets/index.466f5d30.css","assets/vendor.20d16b53.js"])}]});_(x).use(k).mount("#app");export{v as _};