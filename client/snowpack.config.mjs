/** @type {import("snowpack").SnowpackUserConfig } */

import proxy from 'http2-proxy';

export default {
    count: {
        public: '/',
        src: '/_dist_',
    },
    plugins: [
        /* ... */
    ],
    devOptions: {
        port: 3000,
    },
    buildOptions: {
        /* ... */
    },
    routes: [
        {
            src: '/api/.*',
            dest: (req, res) => {
                req.url = req.url.replace(/^\/api\//, '/ludo/api/');
                console.log(req.url);
                return proxy.web(req, res, {
                    hostname: 'localhost',
                    port: 8080,
                });
            },
        },
    ],
    alias: {
        /* ... */
    },
}