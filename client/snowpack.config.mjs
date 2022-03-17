/** @type {import("snowpack").SnowpackUserConfig } */
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
                req.url = req.url.replace(/^\/api\//, '/');

                return null /*proxy.web(req, res, {
                    hostname: 'localhost',
                    port: 8080,
                });*/
            },
        },
    ],
    alias: {
        /* ... */
    },
}