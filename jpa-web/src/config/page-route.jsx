import React from 'react';
import Home from './../pages/Home.jsx';

const routes = [
    {
        path: '/',
        exact: true,
        title: 'Home',
        component: () => <Home/>
    }
];


export default routes;