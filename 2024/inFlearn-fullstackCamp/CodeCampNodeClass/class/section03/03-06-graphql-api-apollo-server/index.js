import { ApolloServer } from '@apollo/server';
import { startStandaloneServer } from '@apollo/server/standalone';

// The GraphQL schema
// 쿼리에 대한 타입을 적겠다 라는 의미
const typeDefs = `#graphql
    type Query {
        hello: String
    }
`

// A map of functions which return data for the schema.
const resolvers = {
  Query: {
    hello: () => { 
        return 'hello'
    }
  }
}


const server = new ApolloServer({
    typeDefs : typeDefs,  // 스웨거 부분
    resolvers: resolvers// API 부분 
})

// 기본 포트번호 4000 
startStandaloneServer(server)


/*
const { url } = await startStandaloneServer(server);
console.log(`🚀 Server ready at ${url}`);
*/