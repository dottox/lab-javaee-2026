CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- =========================================
-- POSITIONS
-- =========================================

INSERT INTO positions (id,
                       name,
                       department_id,
                       hierarchy_level,
                       created_at)
VALUES ('11111111-1111-1111-1111-111111111111',
        'ADMIN',
        NULL,
        100,
        NOW()),
       ('22222222-2222-2222-2222-222222222222',
        'USER',
        NULL,
        1,
        NOW())
ON CONFLICT (id) DO NOTHING;


-- =========================================
-- ADMIN USER
-- password: Admin123!
-- =========================================

INSERT INTO users (id,
                   email,
                   username,
                   phone_number,
                   password_hash,
                   validated_at,
                   created_at,
                   updated_at,
                   deleted_at)
VALUES ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
        'admin@citruschat.com',
        'admin',
        '+59899999999',
        '$2a$10$REym006Yo6TmEpL7yLAqluHiChR3NrkGkMpUCIJKw83bDhsYVY3GW', -- Admin123!
        NOW(),
        NOW(),
        NOW(),
        NULL)
ON CONFLICT (id) DO UPDATE SET
                               email = EXCLUDED.email,
                               username = EXCLUDED.username,
                               phone_number = EXCLUDED.phone_number,
                               password_hash = EXCLUDED.password_hash,
                               validated_at = EXCLUDED.validated_at,
                               updated_at = NOW(),
                               deleted_at = NULL;

-- =========================================
-- USER ORGANIZATION
-- =========================================

INSERT INTO user_organization (id,
                               user_id,
                               position_id,
                               manager_id,
                               assigned_at)
VALUES ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
        'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
        '11111111-1111-1111-1111-111111111111',
        NULL,
        NOW())
ON CONFLICT (id) DO NOTHING;