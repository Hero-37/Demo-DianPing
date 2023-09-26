-- 当前线程标识
local threadId = ARGV[1]

-- 获取锁中的标识, KEYS[1]相当于 key-value 中的 key
local id = redis.call('get', KEYS[1])

-- 比较线程标识与锁中的标识是否一致
if (id == ARGV[1]) then
    -- 释放锁 del key
    return redis.call('del', KEYS[1])
end
return 0
